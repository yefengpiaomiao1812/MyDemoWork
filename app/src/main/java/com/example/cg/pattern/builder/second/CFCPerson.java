package com.example.cg.pattern.builder.second;


public class CFCPerson {

    private int id;
    private String name;
    private int age;
    private String address;

    public CFCPerson() {
    }

    public CFCPerson(PersonBuilder personBuilder) {
        this.id = personBuilder.id;
        this.name = personBuilder.name;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public static CFCPerson.PersonBuilder builder() {
        return new CFCPerson.PersonBuilder();
    }

    public static class PersonBuilder {

        private int id;
        private String name;
        private int age;
        private String address;

        public PersonBuilder() {
        }

        public CFCPerson build() {
            return new CFCPerson(this);
        }

        public PersonBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }
    }

    @Override
    public String toString() {
        return "CFCPerson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
