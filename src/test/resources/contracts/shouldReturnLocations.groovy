import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return locations"
    request{
        method GET()
        url("/country/1/location")
    }
    response {
        body("[{\"id\":1,\"name\":\"LocationOneForCountryOne\"}," +
                "{\"id\":2,\"name\":\"LocationTwoForCountryOne\"}]")
        status 200
    }
}