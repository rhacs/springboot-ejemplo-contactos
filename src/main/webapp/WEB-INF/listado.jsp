<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
            crossorigin="anonymous">
        <title>Hello, world!</title>
    </head>
    <body class="py-4">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-10 col-md-12">
                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                                <tr>
                                    <th scope="col" class="text-nowrap">#</th>
                                    <th scope="col" class="text-nowrap">Nombre</th>
                                    <th scope="col" class="text-nowrap">Teléfono</th>
                                    <th scope="col" class="text-nowrap">Email</th>
                                    <th scope="col" class="text-nowrap">Dirección</th>
                                </tr>
                            </thead>

                            <tbody id="cuerpo"></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
            integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

        <script type="text/javascript">
            // Esperar a que termine de cargar la página por completo
            $(function() {
            	// Realizar una petición GET a la API
            	$.get("http://localhost/api/contactos", function(data) {
            		// Imprimir la respuesta por consola
            		console.log("Respuesta API:");
            		console.log(data);

            		// Por cada elemento almacenado dentro de data
            		$.each(data, function() {
            			// Crear una nueva fila
            			let fila = $('<tr>')
            			        .append('<th scope="row" class="text-nowrap">' + this.id + '</th>')
            			        .append('<td>' + this.nombre + '</td>')
            			        .append('<td class="text-nowrap">' + this.telefono + '</td>')
            			        .append('<td class="text-nowrap">' + this.email + '</td>')
            			        .append('<td>' + this.direccion + '</td>');

            			// Agregar nueva fila al cuerpo de la tabla
            			$('#cuerpo').append(fila);
            		});
            	});
            });
        </script>

    </body>
</html>
