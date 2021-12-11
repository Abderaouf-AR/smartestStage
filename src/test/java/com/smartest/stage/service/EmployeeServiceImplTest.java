package com.smartest.stage.service;

import com.smartest.stage.model.*;
import com.smartest.stage.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    private EmployeeServiceImpl employeeServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        employeeServiceImplUnderTest = new EmployeeServiceImpl(mockEmployeeRepository);
    }

    @Test
    void testFindAll() {
        // Setup
        // Configure EmployeeRepository.findAll(...).
        final List<Employee> employees = List.of(new Employee(0, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of())))));
        when(mockEmployeeRepository.findAll()).thenReturn(employees);

        // Run the test
        final List<Employee> result = employeeServiceImplUnderTest.findAll();

        System.out.println(result);
        // Verify the results
        assertArrayEquals(result.toArray(),employees.toArray());
    }

    @Test
    void testFindAll_EmployeeRepositoryReturnsNoItems() {
        // Setup
        when(mockEmployeeRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Employee> result = employeeServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFindById() {
        // Setup
        // Configure EmployeeRepository.findById(...).
        final Optional<Employee> employee = Optional.of(new Employee(0, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of())))));
        when(mockEmployeeRepository.findById(0)).thenReturn(employee);

        // Run the test
        final Employee result = employeeServiceImplUnderTest.findById(0);

        // Verify the results
        assertEquals(result,employee.get());
    }

    @Test
    void testFindById_EmployeeRepositoryReturnsAbsent() {
        // Setup
        when(mockEmployeeRepository.findById(0)).thenReturn(Optional.empty());

        // Run the test and verify the results
        assertThrows(RuntimeException.class,()->{
            final Employee result = employeeServiceImplUnderTest.findById(0);
        },"Did not find employee id - 0");
    }

    @Test
    void testSave() {
        // Setup
        final Employee employee = new Employee(0, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))));

        // Configure EmployeeRepository.save(...).
        final Employee employee1 = new Employee(0, "firstName", "lastName", "email", "phoneNumber", Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0L, 0L, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, null))), List.of(new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), null, null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))))), List.of(new JobHistory(new JobHistoryPK(0, 0, 0), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), ZonedDateTime.of(LocalDateTime.of(2020, 1, 1, 0, 0, 0), ZoneOffset.UTC), new Job(0, "jobTitle", 0L, 0L, List.of(new Task(0, "title", "description", List.of())), null, List.of()), null, new Department(0, "department", new Location(0, "streetAddress", "postalCode", "city", "stateProvince", List.of(), new Country(0, "countryName", new Region(0, "regionName", List.of()), List.of())), List.of(), List.of()))));
        when(mockEmployeeRepository.save(any(Employee.class))).thenReturn(employee1);

        // Run the test
        employeeServiceImplUnderTest.save(employee);

        // Verify the results
        verify(mockEmployeeRepository).save(any(Employee.class));
    }

    @Test
    void testDeleteById() {
        // Setup
        // Run the test
        employeeServiceImplUnderTest.deleteById(0);

        // Verify the results
        verify(mockEmployeeRepository).deleteById(0);
    }
}
