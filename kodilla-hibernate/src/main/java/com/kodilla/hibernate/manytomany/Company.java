package com.kodilla.hibernate.manytomany;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompaniesByFirstThreeLetters",
        query = "SELECT * FROM companies WHERE LEFT(company_name, 3) = :FIRSTTHREELETTERS ",
        resultClass = Company.class
)

@NamedQuery(
        name = "Company.retrieveCompanyLike",
        query = "FROM Company c WHERE c.name LIKE concat('%',:NAME,'%')"
)
@Entity
@Table(name = "COMPANIES")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
