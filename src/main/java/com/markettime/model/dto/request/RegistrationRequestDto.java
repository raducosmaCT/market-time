package com.markettime.model.dto.request;

import static com.markettime.util.Constants.VALIDATION_NOT_EMPTY;
import static com.markettime.util.Constants.VALIDATION_SIZE;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.markettime.validator.RegistrationValid;

/**
 *
 * @author Radu Cosma
 *
 */
@RegistrationValid
public class RegistrationRequestDto {

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(message = VALIDATION_SIZE, max = 30)
    private String firstName;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(message = VALIDATION_SIZE, max = 30)
    private String lastName;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(message = VALIDATION_SIZE, max = 127)
    private String email;

    @Size(message = VALIDATION_SIZE, min = 8, max = 63)
    private String password;

    @Size(message = VALIDATION_SIZE, min = 8, max = 63)
    private String confirmPassword;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(message = VALIDATION_SIZE, max = 30)
    private String companyName;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(message = VALIDATION_SIZE, max = 100)
    private String companyAddress;

    @NotEmpty(message = VALIDATION_NOT_EMPTY)
    @Size(message = VALIDATION_SIZE, max = 15)
    private String companyPhone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RegistrationDto [firstName=").append(firstName).append(", lastName=").append(lastName)
                .append(", email=").append(email).append(", password=").append(password).append(", confirmPassword=")
                .append(confirmPassword).append(", companyName=").append(companyName).append(", companyAddress=")
                .append(companyAddress).append(", companyPhone=").append(companyPhone).append("]");
        return builder.toString();
    }

}
