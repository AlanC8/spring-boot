//package kz.kbtu.sis6.contoller
//
//import io.swagger.v3.oas.annotations.Operation
//import io.swagger.v3.oas.annotations.responses.ApiResponse
//import io.swagger.v3.oas.annotations.responses.ApiResponses
//import io.swagger.v3.oas.models.media.ArraySchema
//import io.swagger.v3.oas.models.media.Schema
//import jakarta.persistence.Entity
//import jakarta.persistence.Id
//import jakarta.validation.constraints.NotBlank
//import jakarta.validation.constraints.Size
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//import javax.swing.text.AbstractDocument.Content
//
//@Entity
//data class Foo(
//    @Id
//    val id: Long = 0,
//
//    @NotBlank
//    @Size(min = 0, max = 50)
//    val name: String = ""
//)
//
//@RestController
//@RequestMapping("/")
//class FooController() {
//    val fooList: List = listOf(Foo(1, "one"), Foo(2, "two"))
//
//    @Operation(summary = "Get all foos")
//    @ApiResponses(value = [
//        ApiResponse(responseCode = "200", description = "Found Foos", content = [
//            (Content(mediaType = "application/json", array = (
//                    ArraySchema(schema = Schema(implementation = Foo::class)))))]),
//        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
//        ApiResponse(responseCode = "404", description = "Did not find any Foos", content = [Content()])]
//    )
//    @GetMapping("/foo")
//    fun getAllFoos(): List = fooList
//}