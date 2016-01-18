package com.mkyong.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/users")
public class AnnotationsTest {
	/*-----------------NORMAL URI MATCHING-------------------*/
	/*@GET
	public Response getUser() {
		return Response.status(200).entity("getUser is called").build();
	}
	@GET
	@Path("/vip")
	public Response getUserVIP() {
		return Response.status(200).entity("getUserVIP is called").build();
	}*/
	
	/*------------URI Matching and Parameter------------*/
	/*@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {

		return Response.status(200)
			.entity("getUserByName is called, name : " + name).build();
	}*/
	
	/*--------URI Matching and Regular Expression--------*/
	/*@GET
	@Path("{id : \\d+}") //support digit only
	public Response getUserById(@PathParam("id") String id) {

	   return Response.status(200).entity("getUserById is called, id : " + id).build();

	}

	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {

	   return Response.status(200)
		.entity("getUserByUserName is called, username : " + username).build();

	}
	
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

	   return Response.status(200)
		.entity("getUserBookByISBN is called, isbn : " + isbn).build();

	}*/
	/*--------@PathParam – Multiple Parameters---------*/
	/*@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month, 
			@PathParam("day") int day) {

	   String date = year + "/" + month + "/" + day;

	   return Response.status(200)
		.entity("getUserHistory is called, year/month/day : " + date)
		.build();
	}*/
	/*----------@QueryParam example------------*/
	/*@GET
	@Path("/query")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {

		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
	}*/
	
	/*-----------@FormParamExample----------------*/
	@POST
	@Path("/add")
	public Response addUser(@FormParam ("name") String name, @FormParam ("age") int age){
		return Response.status(200).entity("addUser is called by, name : \t" + name + "\t age \t" + age).build();
	}
	/*-----------Download File in JAX-RS-----------*/
	/*
	private static final String FILE_PATH = "c:\\Users\\User\\workspace\\file.log";
	@GET
	@Path("/getfile")
	@Produces("text/plain")
	public Response getFile(){
		
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename=\"file_from_server.log\"");
			return response.build();
	}*/
	/*-----------Download File in JAX-RS excel-file-----------*/
	/*
	private static final String FILE_PATH = "c:\\Users\\User\\workspace\\excel.xlsx";
	@GET
	@Path("/getfile")
	@Produces("application/vnd.ms-exceln")
	public Response getFile(){
		
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename=\"excel-file.xlsx");
			return response.build();
	}*/
	
	/*---------@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}----------*/

}