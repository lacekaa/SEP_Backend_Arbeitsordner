package sep.arbeitspaket.rest.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sep.arbeitspaket.rest.person.*;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PersonControllerIntegrationstest {
    private static final String API_ROOT = "http://localhost:8080/";
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //all Person Test
    @Test
    public void allPersonITest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/person-controller/find-all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();


        assertEquals(personRepository.findAll(), personService.findAll());
    }

    //alter birthday date class
    @Test
    public void findByIdTest() throws Exception {
        LastName yuuLastName = new LastName("Kruth");
        FirstName yuuFirstName = new FirstName("Yuu");
        Birthday birthday = new Birthday(new Date(2000,01,01));
        Person yuu = new Person(yuuFirstName, yuuLastName, birthday);
        personService.addPerson(yuu);
        Long id = yuu.getId();
        Optional<Person> found = personService.findById(id);
        assertEquals(yuu.getId(), found.get().getId());
    }

    @Test
    public void deleteByIdUnit() {
        LastName yuuLastName = new LastName("Kruth");
        FirstName yuuFirstName = new FirstName("Yuu");
        Birthday birthday = new Birthday(new Date(2000,01,01));
        Person yuu = new Person(yuuFirstName, yuuLastName, birthday);
        personRepository.save(yuu);
        Long id = yuu.getId();
        personService.deleteById(id);
        assertEquals(Optional.empty(), personService.findById(id));
    }

    @Test
    public void deleteById() throws Exception {
        LastName yuuLastName = new LastName("Kruth");
        FirstName yuuFirstName = new FirstName("Yuu");
        Birthday birthday = new Birthday(new Date(2000,01,01));
        Person yuu = new Person(yuuFirstName, yuuLastName, birthday);
        personRepository.save(yuu);
        Long id = yuu.getId();
        assertEquals(yuu, personRepository.findById(id).orElseThrow(() -> new RuntimeException("person not found")));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/person-controller/delete-by-id/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(Optional.empty(), personRepository.findById(id));
    }

    }
