package grailsintro

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DepartmentsSpec extends Specification implements DomainUnitTest<Departments> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
