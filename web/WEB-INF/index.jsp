<%-- 
    Document   : index
    Created on : Mar 17, 2013, 6:54:37 PM
    Author     : awanlabs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            
            h1{
                border-bottom: 1px solid appworkspace;
            }
            
            table,th,td{
              border:1px solid activeborder;
              border-collapse: collapse;
            }
            
            table{
                margin-top: 10px;
            }
            
            td{
                font-family: helvetica;
                padding: 5px;
            }
            
            a{
                text-decoration: none;
            }
            
            #tambah{
                font-size: 18px;
                display: block;
                background: beige;
                width: 105px;
                padding: 5px;
                border: 1px solid activeborder;
            }
            
            #tambah:hover{
                background: burlywood;
            }
        </style>
    </head>
    <body>
        <h1>Data Mahasiswa</h1>
        <a id="tambah" href="<c:url value="?page=tambah"/>">Tambah Data</a>
        <table>
            <thead>
              <tr>
              <th>Nim</th>
              <th>Nama</th>
              <th>Umur</th>
              <th>Asal Sekolah</th>
              <th>Alamat</th>
              <th>#</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${mahasiswas}" var="mahasiswa">
                    <tr>
                        <td>${mahasiswa.nim}</td>
                        <td>${mahasiswa.nama}</td>
                        <td>${mahasiswa.umur}</td>
                        <td>${mahasiswa.asalSekolah}</td>
                        <td>${mahasiswa.alamat}</td>
                        <td><a href="<c:url value="?page=edit&nim=${mahasiswa.nim}"/>">Edit</a> | 
                            <a href="<c:url value="?page=hapus&nim=${mahasiswa.nim}"/>">Hapus</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>  
    </body>
</html>
