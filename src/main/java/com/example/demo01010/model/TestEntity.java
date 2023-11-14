package com.example.demo01010.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "DB_test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, length = 6)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false, length = 60)
    private String name;

    // Constructors
    public TestEntity() {
    }

    public TestEntity(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    //สร้าง Getter,Setter ทุก attribute เพืิ่อดึงค่า
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //ใช้ toString เพื่อ debugging logging และแสดงข้อมูล object เป็น String
    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // hashCode ใช้สร้างรหัสแทนข้อมูล object เพื่อช่วยค้นหาข้อมูลที่ใช้ hash table และ hash map
    // Objects.hash() ช่วยสร้างรหัส hash มี id, email, password, name
    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name);
    }

    //equals เพื่อเปรียบเทียบ object อื่นเพื่อดูว่ามันมีข้อมูลเหมือนกันหรือป่าว
    //Objects.equals() ช่วยในการเปรียบเทียบทุกค่าใน object งับบบ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name);
    }
}