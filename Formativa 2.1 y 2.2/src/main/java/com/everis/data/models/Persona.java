	package com.everis.data.models;
	 
	import java.util.Date;
	 
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.PrePersist;
	import javax.persistence.PreUpdate;
	import javax.persistence.Table;
	 
	import org.springframework.format.annotation.DateTimeFormat;
	 
	@Entity //
	@Table(name="personas")
	public class Persona {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Integer rut;
	    private String dv; //digito verificador
	    private String nombre;
	    private String apellido;
	    private String email;

	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;

	    public Persona() {
	        super();
	    }
	 
	    public Persona(Integer rut, String dv, String nombre, String apellido, String email) {
	        super();
	        this.rut = rut;
	        this.dv = dv;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.email = email;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public void setRut(Integer rut) {
	        this.rut = rut;
	    }
	 
	    public void setDv(String dv) {
	        this.dv = dv;
	    }
	 
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	 
	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Long getId() {
	        return id;
	    }
	 
	    public Integer getRut() {
	        return rut;
	    }
	 
	    public String getDv() {
	        return dv;
	    }
	 
	    public String getNombre() {
	        return nombre;
	    }
	 
	    public String getApellido() {
	        return apellido;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    @PrePersist
	    protected void onCreate(){
	    this.createdAt = new Date();
	    }
	    //antes de que el objeto sea actualizado
	    @PreUpdate
	    protected void onUpdate(){
	    this.updatedAt = new Date();
	    }


}
