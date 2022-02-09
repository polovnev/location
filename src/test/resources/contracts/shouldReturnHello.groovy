package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return hello"
    request{
        method GET()
        url("/country/hello")
    }
    response {
        body("hello")
        status 200
    }
}