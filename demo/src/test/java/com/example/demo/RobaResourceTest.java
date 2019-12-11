package com.example.demo;



import com.example.demo.controller.RobaController;
import com.example.demo.model.Roba;
import com.example.demo.repository.RobaRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class RobaResourceTest {

    private MockMvc mock;

    @Mock
    private RobaRepository repository;

    @InjectMocks
    private RobaController robaController;

    @Before
    public void setUp() throws Exception {
        Roba roba=new Roba();
        roba.setId(1L);
        roba.setNaziv("Roba Updated");
        mock = MockMvcBuilders.standaloneSetup(robaController).build();
        when(repository.findById(1L)).thenReturn(Optional.of(roba));
    }

    @Test
    public  void testGetRoba() throws Exception {
        mock.perform(get("/roba/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.naziv", Matchers.is("Roba Updated")));

    }

}