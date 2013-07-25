<%-- 
    Document   : formTambah
    Created on : Mar 17, 2013, 7:00:16 PM
    Author     : awanlabs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            h1{
                border-bottom: 1px solid appworkspace;
            }
            
            table{
                border: 1px solid activeborder;
                padding: 3px;
                border-radius: 5px;
            }
            
            input{
                padding: 5px;
            }
            
            form{
                font-family: helvetica;
            }
            
            #simpan{
                background: beige;
                border: 1px solid activeborder;
                padding: 10px;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Tambah</h1>
        <form>
            <table>
                <tr>
                    <td>Nim</td>
                    <td>:</td>
                    <td><input type="text" name="nim"/></td>
                </tr>
                
                <tr>
                    <td>Nama</td>
                    <td>:</td>
                    <td><input type="text" name="nama"/></td>
                </tr>
                
                <tr>
                    <td>Umur</td>
                    <td>:</td>
                    <td><input type="text" name="umur"/></td>
                </tr>
                
                <tr>
                    <td>Asal Sekolah</td>
                    <td>:</td>
                    <td><input type="text" name="asalSekolah"/></td>
                </tr>
                
                <tr>
                    <td>Alamat</td>
                    <td>:</td>
                    <td><input type="text" name="alamat"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Simpan" id="simpan"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
