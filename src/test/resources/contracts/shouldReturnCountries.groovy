import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return countries"
    request{
        method GET()
        url("/country")
    }
    response {
        body("[{\"id\":1,\"name\":\"countryOne\"}," +
                "{\"id\":2,\"name\":\"countryTwo\"}]")
        status 200
    }
}