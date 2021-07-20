package grailsintro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DepartmentsServiceSpec extends Specification {

    DepartmentsService departmentsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Departments(...).save(flush: true, failOnError: true)
        //new Departments(...).save(flush: true, failOnError: true)
        //Departments departments = new Departments(...).save(flush: true, failOnError: true)
        //new Departments(...).save(flush: true, failOnError: true)
        //new Departments(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //departments.id
    }

    void "test get"() {
        setupData()

        expect:
        departmentsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Departments> departmentsList = departmentsService.list(max: 2, offset: 2)

        then:
        departmentsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        departmentsService.count() == 5
    }

    void "test delete"() {
        Long departmentsId = setupData()

        expect:
        departmentsService.count() == 5

        when:
        departmentsService.delete(departmentsId)
        sessionFactory.currentSession.flush()

        then:
        departmentsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Departments departments = new Departments()
        departmentsService.save(departments)

        then:
        departments.id != null
    }
}
