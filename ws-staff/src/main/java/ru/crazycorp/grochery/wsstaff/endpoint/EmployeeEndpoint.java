package ru.crazycorp.grochery.wsstaff.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.crazycorp.grochery.wsstaff.generated.employee.GetEmployeeRequest;
import ru.crazycorp.grochery.wsstaff.generated.employee.GetEmployeeResponse;
import ru.crazycorp.grochery.wsstaff.repository.EmployeeRepository;

@Endpoint
public class EmployeeEndpoint {
    private static final String NAMESPACE_URI = "http://wsstaff.grochery.crazycorp.ru/generated/employee";

    private EmployeeRepository empRepository;

    @Autowired
    public EmployeeEndpoint(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(empRepository.findEmployee(request.getId()));
        return response;
    }
}