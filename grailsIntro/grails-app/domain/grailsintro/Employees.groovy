package grailsintro

class Employees {

    String empName
    int empNumber
    String location

    static hasMany = [departments:Departments]

    static constraints = {
        empNumber(unique:true)
    }

    static mapping = {
        table 'EMPL'
        empName column :'E_NAME'
        empId column :'E_ID'
    }
}
