package grailsintro

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EmployeesSpec extends Specification implements DomainUnitTest<Employees> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
