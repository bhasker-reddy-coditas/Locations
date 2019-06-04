package com.location;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.location.controller.LocationResource;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationResource.class)
public class LocationResourceTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void givenSearchParams_whenSearchVenues_thenReturnJsonObject() throws Exception {

		mvc.perform(get("/api/searchVenues?near=Pune india&intent=browse&radius=10000&limit=10&query=KFC")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				
				//check if the jason node exsits
                .andExpect(jsonPath("$.meta").exists())
                .andExpect(jsonPath("$.response").exists())
                .andExpect(jsonPath("$.response.venues").exists())
                .andExpect(jsonPath("$.response.venues").isArray())
                .andExpect(jsonPath("$.response.venues[0].name").value("KFC"))
                .andExpect(jsonPath("$.response.venues[0].venueDetails").exists());
	}

}
