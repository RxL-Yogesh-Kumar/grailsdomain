package grailsintro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DepartmentsController {
    static scaffold=Departments

    DepartmentsService departmentsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond departmentsService.list(params), model:[departmentsCount: departmentsService.count()]
    }

    def show(Long id) {
        respond departmentsService.get(id)
    }

    def create() {
        respond new Departments(params)
    }

    def save(Departments departments) {
        if (departments == null) {
            notFound()
            return
        }

        try {
            departmentsService.save(departments)
        } catch (ValidationException e) {
            respond departments.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'departments.label', default: 'Departments'), departments.id])
                redirect departments
            }
            '*' { respond departments, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond departmentsService.get(id)
    }

    def update(Departments departments) {
        if (departments == null) {
            notFound()
            return
        }

        try {
            departmentsService.save(departments)
        } catch (ValidationException e) {
            respond departments.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'departments.label', default: 'Departments'), departments.id])
                redirect departments
            }
            '*'{ respond departments, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        departmentsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'departments.label', default: 'Departments'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'departments.label', default: 'Departments'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
