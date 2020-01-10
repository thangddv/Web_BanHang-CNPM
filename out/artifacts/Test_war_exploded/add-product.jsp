<%-- 
    Document   : add-product
    Created on : Dec 17, 2019, 2:42:22 PM
    Author     : lionfun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin - Customer</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    
    <body>
<body id="page-top">

<jsp:include page="navigation.jsp"/>

<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="sidebar.jsp"/>
    
    
    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Add Product</li>
            </ol>

            <!-- DataTables Example -->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Product</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <form method="post" action="add-product" enctype="multipart/form-data">
                            <div>
                                <label for="product_name" class="col-sm-12 col-md-2">Name</label>
                                <input type="text" name="name" id="product_name" class="col-sm-12 col-md-8"
                                       path="product_name" />
                            </div>
                            <div>
                                <label for="price" class="col-sm-12 col-md-2">Price</label>
                                <input type="text" name="price" id="price" class="col-sm-12 col-md-8"
                                       path="price" />
                            </div>
                            <div>
                                <label for="description" class="col-sm-12 col-md-2">Description</label>
                                <input type="text" name="description" id="description" class="col-sm-12 col-md-8"
                                       path="description" />
                            </div>
                            <div>
                                <label for="description_detail" class="col-sm-12 col-md-2">Description detail</label>
                                <input type="text" name="description_detail" id="description_detail" class="col-sm-12 col-md-8"
                                       path="description_detail" />
                            </div>
                            <div>
                                <label for="image" class="col-sm-12 col-md-2">Image</label>
                                <input type="file" name="image" id="image" class="col-sm-12 col-md-5">
                            </div>
                            <input type="submit" name="submit" class ="btn btn-outline-secondary" value="Add product">
                        </form>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>

<%--
            <p class="small text-center text-muted my-5">
                <em>More table examples coming soon...</em>
            </p>
--%>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright Â© Your Website 2019</span>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">Ã</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.jsp">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>

</body>
    </body>
    
</html>
