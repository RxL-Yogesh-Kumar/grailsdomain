package grailsintro

import grails.gorm.services.Service

@Service(Employees)
interface EmployeesService {

    Employees get(Serializable id)

    List<Employees> list(Map args)

    Long count()

    void delete(Serializable id)

    Employees save(Employees employees)

}