package academy.kata.pp_312.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]{1,25}$",
            message = "The name must contain from 1 to 25 characters " +
                    "/ Имя должно содержать от 1 до 25 символов.")
    private String firstName;

    @Column(name = "last_name")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]{1,25}$",
            message = "The last name must contain from 1 to 25 characters " +
                    "/ Фамилия должна содержать от 1 до 25 символов.")
    private String lastName;

    @Column(name = "age")
    @NotNull(message = "Число не должно быть равно null")
    @Digits(integer = 3, fraction = 0, message = "Age should be / Возраст должен быть от 0 до 122")
    @Min(value = 0, message = "Age should be / Возраст должен быть >= 0")
    @Max(value = 122, message = "Age should be / Возраст должен быть < 123")
    private Integer age;

    @Column(name = "email")
    @Pattern(regexp = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@" +
                     "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Enter a valid email address " +
            "/ Введите действительный адрес электронной почты")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("USER [id = %d, firstName = '%s', lastName = '%s', age = %d, email = '%s']",
                id, firstName, lastName, age, email);
    }
}
