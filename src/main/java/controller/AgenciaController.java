package controller;

import domain.Agencia;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;
import service.AgenciaService;

@Path("/agencias")
public class AgenciaController {

  private final AgenciaService agenciaService;

  AgenciaController(AgenciaService agenciaService) {
    this.agenciaService = agenciaService;
  }

  @POST
  @NonBlocking
  public Uni<RestResponse<Void>> cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
    return this.agenciaService.cadastrar(agencia)
        .replaceWith(RestResponse.created(uriInfo.getAbsolutePathBuilder().build()));
  }

  @GET
  @Path("{id}")
  public Uni<RestResponse<Agencia>> buscarPorId(@PathParam("id") Long id) {
    Uni<Agencia> agencia = this.agenciaService.buscarPorId(id);
    return agencia.onItem().transform(RestResponse::ok);
  }

  @DELETE
  @NonBlocking
  @Path("{id}")
  public Uni<RestResponse<Void>> deletar(@PathParam("id") Long id) {
    return this.agenciaService.deletar(id).replaceWith(RestResponse.ok());
  }

  @PUT
  @NonBlocking
  public Uni<RestResponse<Void>> alterar(Agencia agencia) {
    return this.agenciaService.alterar(agencia).replaceWith(RestResponse.ok());
  }
}
