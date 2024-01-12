package com.solvd.laba;

import com.solvd.laba.domain.employee.Department;
import com.solvd.laba.domain.employee.Employee;
import com.solvd.laba.domain.employee.Salary;
import com.solvd.laba.domain.hospital.Hospital;
import com.solvd.laba.domain.patient.*;
import com.solvd.laba.persistence.hospitalDAO.IHospitalDAO;
import com.solvd.laba.persistence.hospitalDAO.hospitalDAOImpl.HospitalDAOImpl;
import com.solvd.laba.persistence.hospitalDAO.hospitalDAOImpl.myBatis.HospitalBImpl;
import com.solvd.laba.service.employeeService.IDepartmentService;
import com.solvd.laba.service.employeeService.IEmployeeService;
import com.solvd.laba.service.employeeService.ISalaryService;
import com.solvd.laba.service.employeeService.employeeServiceImpl.DepartmentServiceImpl;
import com.solvd.laba.service.employeeService.employeeServiceImpl.EmployeeServiceImpl;
import com.solvd.laba.service.employeeService.employeeServiceImpl.SalaryServiceImpl;
import com.solvd.laba.service.hospitalService.IHospitalService;
import com.solvd.laba.service.hospitalService.hospitalServiceImpl.HospitalServiceImpl;
import com.solvd.laba.service.patientService.*;
import com.solvd.laba.service.patientService.patientServiceImpl.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IHospitalService hospitalService = new HospitalServiceImpl();
        IEmployeeService employeeService = new EmployeeServiceImpl();
        IDepartmentService departmentService = new DepartmentServiceImpl();
        ISalaryService salaryService = new SalaryServiceImpl();
        IAppointmentService appointmentService = new AppointmentServiceImpl();
        IBillingService billingService = new BillingServiceImpl();
        ILaboratoryTestService laboratoryTestService = new LaboratoryServiceImpl();
        IMedicationService medicationService = new MedicationServiceImpl();
        IPatientService patientService = new PatientServiceImpl();
        IRoomService roomService = new RoomServiceImpl();

// find by id
//        Hospital hospital = hospitalService.getById(1);
//        System.out.println(hospital);
//        System.out.println("----------------------------------------------");
//
//        Employee employee = employeeService.getById(2);
//        System.out.println(employee);
//        System.out.println("----------------------------------------------");
//
//        Department department = departmentService.getById(3);
//        System.out.println(department);
//        System.out.println("----------------------------------------------");
//
//        Salary salary = salaryService.getById(4);
//        System.out.println(salary);
//        System.out.println("----------------------------------------------");
//
//        Appointment appointment = appointmentService.getById(1);
//        System.out.println(appointment);
//        System.out.println("----------------------------------------------");
//
//        Billing billing = billingService.getById(2);
//        System.out.println(billing);
//        System.out.println("----------------------------------------------");
//
//        LaboratoryTest laboratoryTest = laboratoryTestService.getById(1);
//        System.out.println(laboratoryTest);
//        System.out.println("----------------------------------------------");
//
//        Medication medication = medicationService.getById(1);
//        System.out.println(medication);
//        System.out.println("----------------------------------------------");
//
//        Patient patient = patientService.getById(1);
//        System.out.println(patient);
//        System.out.println("----------------------------------------------");
//
//        Room room = roomService.getById(12);
//        System.out.println(room);
//        System.out.println("----------------------------------------------");


        // insert
//        Hospital hospital1 = new Hospital(7,"someOne");
//        hospitalService.insert(hospital1);
//        System.out.println("----------------------------------------------");
//
//        Department department1 = new Department(4, "workers");
//        departmentService.insert(department1);
//        System.out.println("----------------------------------------------");

//        Employee employee1 = new Employee(6, "something", "something", 4, 2);
//        employeeService.insert(employee1);
//        System.out.println("----------------------------------------------");

//        Salary salary1 = new Salary(6, 40000.0);
//        salaryService.insert(salary1);
//        System.out.println("----------------------------------------------");

//        Appointment appointment1 = new Appointment(6, "something", 1);
//        appointmentService.insert(appointment1);
//        System.out.println("----------------------------------------------");

//        Billing billing1 = new Billing(6, "something", 122.45, 5);
//        billingService.insert(billing1);
//        System.out.println("----------------------------------------------");

//        LaboratoryTest laboratoryTest1 = new LaboratoryTest(6, "something", 4);
//        laboratoryTestService.insert(laboratoryTest1);
//        System.out.println("----------------------------------------------");

//        Medication medication1 = new Medication(6, "something", "something", 3);
//        medicationService.insert(medication1);
//        System.out.println("----------------------------------------------");

//        Patient patient1 = new Patient(6, "sam", "sulak", 2);
//        patientService.insert(patient1);
//        System.out.println("----------------------------------------------");

//        Room room1 = new Room(13, 6);
//        roomService.insert(room1);
//        System.out.println("----------------------------------------------");

 // update

//        Hospital hospital2 = new Hospital(7, "something");
//        hospitalService.update(hospital2);
//        System.out.println("----------------------------------------------");

//        Department department2 = new Department(4, "WORKER");
//        departmentService.update(department2);
//        System.out.println("----------------------------------------------");

//        Employee employee2 = new Employee(6, "sara", "sdf", 3, 3);
//        employeeService.update(employee2);
//        System.out.println("----------------------------------------------");

//        Salary salary2 = new Salary(6, 35000.0);
//        salaryService.update(salary2);
//        System.out.println("----------------------------------------------");

//        Appointment appointment2 = new Appointment(6, "alksdjfsl", 6);
//        appointmentService.update(appointment2);
//        System.out.println("----------------------------------------------");

//        Billing billing2 = new Billing(6, "first visit fee", 15.99, 6);
//        billingService.update(billing2);
//        System.out.println("----------------------------------------------");

//        LaboratoryTest laboratoryTest2 = new LaboratoryTest(6, "alskdfj", 6);
//        laboratoryTestService.update(laboratoryTest2);
//        System.out.println("----------------------------------------------");

//        Medication medication2 = new Medication(6, "lxkc", "s;lkdfj", 6);
//        medicationService.update(medication2);
//        System.out.println("----------------------------------------------");

//        Patient patient2 = new Patient(6, "sam", "hulk", 3);
//        patientService.update(patient2);
//        System.out.println("----------------------------------------------");

//        Room room2 = new Room(13,5);
//        roomService.update(room2);
//        System.out.println("----------------------------------------------");

        // delete
//        Hospital hospital3 = new Hospital();
//        hospital.setHospitalId(7);
//        hospitalService.delete(hospital);

//        Department department3 = new Department();
//        department3.setDepartmentId(4);
//        departmentService.delete(department3);

//        Employee employee3 = new Employee();
//        employee3.setEmployeeId(7);
//        employeeService.delete(employee3);

//        Salary salary3 = new Salary();
//        salary3.setEmployeeId(6);
//        salaryService.delete(salary3);

//        Appointment appointment3 = new Appointment();
//        appointment3.setAppointmentId(6);
//        appointmentService.delete(appointment3);

//        Billing billing3 = new Billing();
//        billing3.setBillNumber(5);
//        billingService.delete(billing3);

//        LaboratoryTest laboratoryTest3 = new LaboratoryTest();
//        laboratoryTest3.setId(6);
//        laboratoryTestService.delete(laboratoryTest3);

//        Medication medication3 = new Medication();
//        medication3.setMedicationId(6);
//        medicationService.delete(medication3);

//        Patient patient3 = new Patient();
//        patient3.setPatientId(6);
//        patientService.delete(patient3);

//        Room room3 = new Room();
//        room3.setRoomNumber(13);
//        roomService.delete(room3);

        // getAll

//        System.out.println(hospitalService.getAllHospitals());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(departmentService.getAllDepartments());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(employeeService.getAllEmployees());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(salaryService.getAllSalaries());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(appointmentService.getAllAppointments());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(billingService.getAllBillings());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(laboratoryTestService.getAllLaboratoryTests());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(medicationService.getAllMedications());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(patientService.getAllPatients());
//        System.out.println("----------------------------------------------");
//
//        System.out.println(roomService.getAllRooms());
//        System.out.println("----------------------------------------------");

        // get lists
//        Hospital hospital4 = hospitalService.getById(2);
//        System.out.println(hospital4);
//
//        Department department = departmentService.getById(1);
//        System.out.println(department);

//        Patient patient4 = patientService.getById(1);
//        System.out.println(patient4);
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sessionFactory.openSession(true);
            IHospitalDAO iHospitalDAO1 = sqlSession.getMapper(IHospitalDAO.class);
            //Hospital h = iHospitalDAO1.getById(2);
            System.out.println(iHospitalDAO1.getById(2));
        }catch (IOException e){
            throw new RuntimeException(e);
        }






//        IHospitalDAO iHospitalDAO = new HospitalBImpl();
//        System.out.println(iHospitalDAO.getById(1));
    }
}
