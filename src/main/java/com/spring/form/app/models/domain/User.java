package com.spring.form.app.models.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.spring.form.app.validators.idValidator.IdentificadorRegex;
import com.spring.form.app.validators.requiredValidator.Requerido;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component(value = "user")
public class User {

    // @Pattern(regexp = "[0-9]{2}[.,-][\\d]{3}[.,-][\\d]{3}[-][A-Z]{1}")
    @IdentificadorRegex // custom validator anotation
    private String id;

    // @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 12)
    private String nombre;

    // @NotBlank(message = "El apellido no puede estar vacío")
    @Requerido
    @Size(min = 4, max = 12)
    private String apellido;

    @NotEmpty
    @Size(min = 4, max = 12)
    private String username;

    @Requerido()
    @Size(min = 4, max = 12)
    private String password;

    @NotBlank // para primitivos
    @Email
    private String email;

    @Min(5)
    @Max(5000)
    @NotNull // para objetos
    private Integer cuenta;

    @NotNull
    // @Past
    // @Future
    // @DateTimeFormat(pattern = "yyyy-MM-dd") // para formatear la fecha
    private Date fechaNacimiento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
