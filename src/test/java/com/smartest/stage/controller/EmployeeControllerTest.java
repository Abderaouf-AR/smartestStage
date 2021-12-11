package com.smartest.stage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartest.stage.model.*;
import com.smartest.stage.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private EmployeeService mockEmployeeService;

    @Test
    void testFindAll() throws Exception {
        // Setup
        // Configure EmployeeService.findAll(...).
        String expected="[{\"id\":0,\"firstName\":null,\"lastName\":null,\"email\":null,\"phoneNumber\":null,\"hireDate\":null,\"salary\":null,\"comissionPct\":null,\"department\":null,\"jobs\":null,\"jobHistories\":null},{\"id\":0,\"firstName\":null,\"lastName\":null,\"email\":null,\"phoneNumber\":null,\"hireDate\":null,\"salary\":null,\"comissionPct\":null,\"department\":null,\"jobs\":null,\"jobHistories\":null},{\"id\":0,\"firstName\":null,\"lastName\":null,\"email\":null,\"phoneNumber\":null,\"hireDate\":null,\"salary\":null,\"comissionPct\":null,\"department\":null,\"jobs\":null,\"jobHistories\":null},{\"id\":0,\"firstName\":null,\"lastName\":null,\"email\":null,\"phoneNumber\":null,\"hireDate\":null,\"salary\":null,\"comissionPct\":null,\"department\":null,\"jobs\":null,\"jobHistories\":null}]";
        final List<Employee> employees = List.of(new Employee(),new Employee(),new Employee(),new Employee());
        when(mockEmployeeService.findAll()).thenReturn(employees);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employees")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(expected);
    }

    @Test
    void testFindAll_EmployeeServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockEmployeeService.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employees")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetEmployee() throws Exception {
        // Setup
        // Configure EmployeeService.findById(...).
        String expected="{\"id\":0,\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"email\":\"email\",\"phoneNumber\":\"phoneNumber\",\"hireDate\":\"2019-12-31T23:00:00.000+00:00\",\"salary\":0,\"comissionPct\":0,\"department\":{\"id\":0,\"department\":\"department\",\"location\":{\"id\":0,\"streetAddress\":\"streetAddress\",\"postalCode\":\"postalCode\",\"city\":\"city\",\"stateProvince\":\"stateProvince\",\"departments\":[],\"country\":{\"id\":0,\"countryName\":\"countryName\",\"region\":{\"id\":0,\"regionName\":\"regionName\",\"countriesById\":[]},\"locations\":[]}},\"employees\":[],\"jobHistories\":[{\"jobhistoryPK\":{\"jobId\":0,\"employeeId\":0,\"departmentId\":0},\"startDate\":\"2020-01-01T00:00:00Z\",\"endDate\":\"2020-01-01T00:00:00Z\",\"job\":{\"id\":0,\"jobTitle\":\"jobTitle\",\"minSalary\":0,\"maxSalary\":0,\"employee\":null,\"jobHistories\":[],\"tasks\":[{\"id\":0,\"title\":\"title\",\"description\":\"description\",\"jobs\":[]}]},\"employee\":null,\"department\":null}]},\"jobs\":[{\"id\":0,\"jobTitle\":\"jobTitle\",\"minSalary\":0,\"maxSalary\":0,\"employee\":null,\"jobHistories\":[{\"jobhistoryPK\":{\"jobId\":0,\"employeeId\":0,\"departmentId\":0},\"startDate\":\"2020-01-01T00:00:00Z\",\"endDate\":\"2020-01-01T00:00:00Z\",\"job\":null,\"employee\":null,\"department\":{\"id\":0,\"department\":\"department\",\"location\":{\"id\":0,\"streetAddress\":\"streetAddress\",\"postalCode\":\"postalCode\",\"city\":\"city\",\"stateProvince\":\"stateProvince\",\"departments\":[],\"country\":{\"id\":0,\"countryName\":\"countryName\",\"region\":{\"id\":0,\"regionName\":\"regionName\",\"countriesById\":[]},\"locations\":[]}},\"employees\":[],\"jobHistories\":[]}}],\"tasks\":[{\"id\":0,\"title\":\"title\",\"description\":\"description\",\"jobs\":[]}]}],\"jobHistories\":[{\"jobhistoryPK\":{\"jobId\":0,\"employeeId\":0,\"departmentId\":0},\"startDate\":\"2020-01-01T00:00:00Z\",\"endDate\":\"2020-01-01T00:00:00Z\",\"job\":{\"id\":0,\"jobTitle\":\"jobTitle\",\"minSalary\":0,\"maxSalary\":0,\"employee\":null,\"jobHistories\":[],\"tasks\":[{\"id\":0,\"title\":\"title\",\"description\":\"description\",\"jobs\":[]}]},\"employee\":null,\"department\":{\"id\":0,\"department\":\"department\",\"location\":{\"id\":0,\"streetAddress\":\"streetAddress\",\"postalCode\":\"postalCode\",\"city\":\"city\",\"stateProvince\":\"stateProvince\",\"departments\":[],\"country\":{\"id\":0,\"countryName\":\"countryName\",\"region\":{\"id\":0,\"regionName\":\"regionName\",\"countriesById\":[]},\"locations\":[]}},\"employees\":[],\"jobHistories\":[]}}]}";
        final Employee employee = new Employee(0, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))));
        when(mockEmployeeService.findById(0)).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employees/{employeeId}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(expected);
    }


    @Test
    void testAddEmployee() throws Exception {
        // Setup
        String expected="{\"id\":3,\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"email\":\"email\",\"phoneNumber\":\"phoneNumber\",\"hireDate\":\"2019-12-31T23:00:00.000+00:00\",\"salary\":0,\"comissionPct\":0,\"department\":{\"id\":0,\"department\":\"department\",\"location\":{\"id\":0,\"streetAddress\":\"streetAddress\",\"postalCode\":\"postalCode\",\"city\":\"city\",\"stateProvince\":\"stateProvince\",\"departments\":[],\"country\":{\"id\":0,\"countryName\":\"countryName\",\"region\":{\"id\":0,\"regionName\":\"regionName\",\"countriesById\":[]},\"locations\":[]}},\"employees\":[],\"jobHistories\":[{\"jobhistoryPK\":{\"jobId\":0,\"employeeId\":0,\"departmentId\":0},\"startDate\":\"2020-01-01T00:00:00Z\",\"endDate\":\"2020-01-01T00:00:00Z\",\"job\":{\"id\":0,\"jobTitle\":\"jobTitle\",\"minSalary\":0,\"maxSalary\":0,\"employee\":null,\"jobHistories\":[],\"tasks\":[{\"id\":0,\"title\":\"title\",\"description\":\"description\",\"jobs\":[]}]},\"employee\":null,\"department\":null}]},\"jobs\":[{\"id\":0,\"jobTitle\":\"jobTitle\",\"minSalary\":0,\"maxSalary\":0,\"employee\":null,\"jobHistories\":[{\"jobhistoryPK\":{\"jobId\":0,\"employeeId\":0,\"departmentId\":0},\"startDate\":\"2020-01-01T00:00:00Z\",\"endDate\":\"2020-01-01T00:00:00Z\",\"job\":null,\"employee\":null,\"department\":{\"id\":0,\"department\":\"department\",\"location\":{\"id\":0,\"streetAddress\":\"streetAddress\",\"postalCode\":\"postalCode\",\"city\":\"city\",\"stateProvince\":\"stateProvince\",\"departments\":[],\"country\":{\"id\":0,\"countryName\":\"countryName\",\"region\":{\"id\":0,\"regionName\":\"regionName\",\"countriesById\":[]},\"locations\":[]}},\"employees\":[],\"jobHistories\":[]}}],\"tasks\":[{\"id\":0,\"title\":\"title\",\"description\":\"description\",\"jobs\":[]}]}],\"jobHistories\":[{\"jobhistoryPK\":{\"jobId\":0,\"employeeId\":0,\"departmentId\":0},\"startDate\":\"2020-01-01T00:00:00Z\",\"endDate\":\"2020-01-01T00:00:00Z\",\"job\":{\"id\":0,\"jobTitle\":\"jobTitle\",\"minSalary\":0,\"maxSalary\":0,\"employee\":null,\"jobHistories\":[],\"tasks\":[{\"id\":0,\"title\":\"title\",\"description\":\"description\",\"jobs\":[]}]},\"employee\":null,\"department\":{\"id\":0,\"department\":\"department\",\"location\":{\"id\":0,\"streetAddress\":\"streetAddress\",\"postalCode\":\"postalCode\",\"city\":\"city\",\"stateProvince\":\"stateProvince\",\"departments\":[],\"country\":{\"id\":0,\"countryName\":\"countryName\",\"region\":{\"id\":0,\"regionName\":\"regionName\",\"countriesById\":[]},\"locations\":[]}},\"employees\":[],\"jobHistories\":[]}}]}";
        final Employee employee = new Employee(3, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))));
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/employees")
                        .content(objectMapper.writeValueAsString(employee)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(expected);
        verify(mockEmployeeService).save(any(Employee.class));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/employees")
                        .content("?").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("?");
        verify(mockEmployeeService).save(any(Employee.class));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        // Setup
        // Configure EmployeeService.findById(...).
        final Employee employee = new Employee(0, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))));
        when(mockEmployeeService.findById(0)).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/employees/{employeeId}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockEmployeeService).deleteById(0);
    }
}
