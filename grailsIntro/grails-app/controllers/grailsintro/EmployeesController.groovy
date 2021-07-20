package grailsintro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmployeesController {
    static scaffold=Employees
    EmployeesService employeesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond employeesService.list(params), model:[employeesCount: employeesService.count()]
    }

    def show(Long id) {
        respond employeesService.get(id)
    }

    def create() {
        respond new Employees(params)
    }

    def save(Employees employees) {
        if (employees == null) {
            notFound()
            return
        }

        try {
            employeesService.save(employees)
        } catch (ValidationException e) {
            respond employees.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employees.label', default: 'Employees'), employees.id])
                redirect employees
            }
            '*' { respond employees, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond employeesService.get(id)
    }

    def update(Employees employees) {
        if (employees == null) {
            notFound()
            return
        }

        try {
            employeesService.save(employees)
        } catch (ValidationException e) {
            respond employees.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'employees.label', default: 'Employees'), employees.id])
                redirect employees
            }
            '*'{ respond employees, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        employeesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'employees.label', default: 'Employees'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employees.label', default: 'Employees'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
