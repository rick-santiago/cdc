package contracts

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

org.springframework.cloud.contract.spec.Contract.make {
    description "根据id查询订单详情"
    request {
        url "/orders/123456"
        method GET()
    }
    response {
        status 200
        headers {
            header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
        }
        body("{\"id\":\"123456\", \"name\":\"testOrder\"}")
    }
}
