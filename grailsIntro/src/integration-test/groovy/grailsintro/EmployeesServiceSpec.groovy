package grailsintro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmployeesServiceSpec extends Specification {

    EmployeesService employeesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Employees(...).save(flush: true, failOnError: true)
        //new Employees(...).save(flush: true, failOnError: true)
        //Employees employees = new Employees(...).save(flush: true, failOnError: true)
        //new Employees(...).save(flush: true, failOnError: true)
        //new Employees(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //employees.id
    }

    void "test get"() {
        setupData()

        expect:
        employeesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Employees> employeesList = employeesService.list(max: 2, offset: 2)

        then:
        employeesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        employeesService.count() == 5
    }

    void "test delete"() {
        Long employeesId = setupData()

        expect:
        employeesService.count() == 5

        when:
        employeesService.delete(employeesId)
        sessionFactory.currentSession.flush()

        then:
        employeesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Employees employees = new Employees()
        employeesService.save(employees)

        then:
        employees.id != null
    }
}
