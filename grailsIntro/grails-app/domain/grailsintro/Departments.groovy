package grailsintro

class Departments {

    String departmentName
    int departmentId
    String location

    static hasMany = [employees:Employees]
    static belongsTo = Employees

    static constraints = {
        departmentId(unique:true)
    }

    static mapping = {
        departmentName column :'D_NAME'
    }
}
