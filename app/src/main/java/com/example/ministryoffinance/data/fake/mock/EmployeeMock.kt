package com.example.ministryoffinance.data.fake.mock

import com.example.ministryoffinance.domain.model.Employee

val aliaqbar = Employee(
    id = 1,
    fullName = "Мухамеджанов Алиакбар Атахунович",
    position = "Директор",
    landlineNumber = "0921939123",
    extensionNumber = "12312",
    email = "muhamedjanov@gmail.com",
    room = 444,
    categoryId = 5,
    image = "fff",
)

val sagynbek = Employee(
    id = 2,
    fullName = "Калчороев Сагынбек Кудайбергенович",
    position = "Новенький",
    landlineNumber = "0999887722",
    extensionNumber = "31266754",
    email = "liiiza@gmail.com",
    room = 451,
    categoryId = 6,
    image = "bdfbdf"
)

val taxirjan = Employee(
    id = 3,
    fullName = "Масимов Тахиржан Курбанович",
    position = "Новенький",
    landlineNumber = "0552778891",
    extensionNumber = "123124",
    email = "taxxxir@gmail.com",
    room = 512,
    categoryId = 6,
    image = "kfasjkfna"
)

val erkinbek = Employee(
    id = 4,
    fullName = "Таалайбеков Эркинбек Нуркожоевич",
    position = "Системный администратор",
    landlineNumber = "0990121243",
    extensionNumber = "566212",
    email = "erkinbekzzz@gmail.com",
    room = 123,
    categoryId = 7,
    image = "fasasf"
)

val mockEmployeeList = listOf(aliaqbar, sagynbek, taxirjan, erkinbek)

fun sortByCategory(employeeList: List<Employee>, categoryId: Int?): List<Employee> {
    val result = mutableListOf<Employee>()

    for (employee in employeeList) {
        if (employee.categoryId == categoryId) {
            result.add(employee)
        }
    }
    return result
}