package grailsintro

import grails.gorm.services.Service

@Service(Departments)
interface DepartmentsService {

    Departments get(Serializable id)

    List<Departments> list(Map args)

    Long count()

    void delete(Serializable id)

    Departments save(Departments departments)

}