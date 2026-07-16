package com.employeeproject.employeedetail.repositories;

import com.employeeproject.employeedetail.TestContainerConfiguration;
import com.employeeproject.employeedetail.entities.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Import(TestContainerConfiguration.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

     @Autowired
    private EmployeeRepository employeeRepository;

     private EmployeeEntity employeeEntity;

     @BeforeEach
     void setUp(){
         employeeEntity = EmployeeEntity.builder()
//                 .id(1L)
                 .name("Siddharath")
                 .email("bsiddh667@gmail.com")
                 .salary(100L)
                 .build();
     }

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
      // Arrange,Given
        employeeRepository.save(employeeEntity);
        //Act,when
        List<EmployeeEntity> employeeList = employeeRepository.findByEmail(employeeEntity.getEmail());
      //Assert  ,Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList)
                .isNotEmpty();
        assertThat(employeeList.get(0).getEmail())
                .isEqualTo(employeeEntity.getEmail());

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList(){
          //Given
          String email = "notPresent.458@gmail.com";
        // when
          List<EmployeeEntity> employeeEntityList = employeeRepository.findByEmail(email);
        //Then
        assertThat(employeeEntityList).isNotNull();
        assertThat(employeeEntityList).isEmpty();
    }
}