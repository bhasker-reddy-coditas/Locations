package com.location;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.location.controller.LocationResource;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationResource.class)
@ContextConfiguration(classes = { LocationResourceTestConfiguration.class })
public class LocationResourceTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void givenSearchParams_whenSearchVenues_thenReturnJsonObject() throws Exception {

		mvc.perform(get("/api/searchVenues?near=Pune india&intent=browse&radius=10000&limit=1&query=KFC")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				
				//check if the json node exists
                .andExpect(jsonPath("$.meta").exists())
                .andExpect(jsonPath("$.response").exists())
                .andExpect(jsonPath("$.response.venues").exists())
                .andExpect(jsonPath("$.response.venues").isArray())
                .andExpect(jsonPath("$.response.venues[0].name").value("KFC"))
                .andExpect(jsonPath("$.response.venues[0].venueDetails").exists())
                .andExpect(jsonPath("$.response.venues[0].venueDetails.response").isNotEmpty());
	}
	
	@Test
	public void givenSearchParams_whenFilterVenues_thenVenuesFiltered() throws Exception {

		mvc.perform(get("/api/searchVenues?near=Pune india&intent=browse&radius=10000&limit=10&query=KFC&filter=BBQ Joint")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.meta").exists())
                .andExpect(jsonPath("$.response").exists())
                .andExpect(jsonPath("$.response.venues").exists())
                .andExpect(jsonPath("$.response.venues").isArray())
                .andExpect(jsonPath("$.response.venues[0].categories").isArray())
                .andExpect(jsonPath("$.response.venues[0].categories[0].name").value("BBQ Joint"))
                .andExpect(jsonPath("$.response.venues[0].venueDetails").exists())
                .andExpect(jsonPath("$.response.venues[0].venueDetails.meta.code").value(200))
                .andExpect(jsonPath("$.response.venues[0].venueDetails.response").isNotEmpty());
	}

}
