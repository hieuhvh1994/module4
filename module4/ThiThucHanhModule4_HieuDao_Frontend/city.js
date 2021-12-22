function getAllCities() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "GET",
        url: "http://localhost:8080/cities",
        success: function (data) {
            let content = ""
            for (let  i=0; i< data.length; i++) {
                if (parseInt(data[i].id) %2 != 0) {
                    content +=
                        '    <tr>\n' +
                        '        <th scope="row">'+data[i].id+'</th>\n' +
                        '        <td><a href="#" onclick="viewCity('+data[i].id+')">'+data[i].name+'</a></td>\n' +
                        '        <td>'+data[i].nation.name+'</td>\n' +
                        '        <td><a href="#" onclick="showUpdateCity('+data[i].id+')">Chỉnh Sửa</a> | <a href="#" onclick="showFormDeleteCity('+data[i].id+')">Xóa</a></td>\n' +
                        '    </tr>'
                } else {
                    content +=
                        '    <tr class="table-active">\n' +
                        '        <th scope="row">'+data[i].id+'</th>\n' +
                        '        <td>'+data[i].name+'</td>\n' +
                        '        <td>'+data[i].nation.name+'</td>\n' +
                        '        <td><a href="#" onclick="showUpdateCity('+data[i].id+')">Chỉnh Sửa</a> | <a href="#" onclick="showFormDeleteCity('+data[i].id+')">Xóa</a></td>\n' +
                        '    </tr>'
                }

            }
            document.getElementById("content").innerHTML = content;
        }

    });
}

function getAllNations() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "GET",
        url: "http://localhost:8080/nations",
        success: function (data) {
            let content = ''
            for (let i=0; i<data.length; i++) {
                content += '<option value="'+data[i].id+'">'+data[i].name+'</option>\n'

            }
            document.getElementById("nation").innerHTML = content;
        }
    });

}

function showFormAddCity() {
    $('#FormCity').modal('show')
}


function showFormDeleteCity(id) {
    $('#FormDetails').modal('hide');
    $('#cityIdDelete').val(id)
    $('#FormDelete').modal('show')
}

function addCity() {
    let name =  $('#cityName').val();
    let description =  $('#description').val();
    let gdp =  $('#gdp').val();
    let population =  $('#population').val();
    let national_id = $('#nation').val();
    let area = $('#area').val();
    let data = {
        name : name,
        description: description,
        area : area,
        gdp: gdp,
        population:population,
        nation:{
            id : national_id
        }
    }
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        url: 'http://localhost:8080/cities',
        data: JSON.stringify(data),
        success: function (data) {
            getAllCities()
            closeCityAddForm()
            resetForm();
        }
    })
    event.preventDefault();
}

function showUpdateCity(id) {
    $('#FormDetails').modal('hide');
    $('#FormEditCity').modal('show');
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/cities/' +id,
        success: function (data) {
            $('#cityNameEdit').val(data.name);
            $('#descriptionEdit').val(data.description);
            $('#gdpEdit').val(data.gdp);
            $('#areaEdit').val(data.area);
            $('#populationEdit').val(data.population);
            $('#nationEdit').val(data.nation.id);
            $('#cityIdEdit').val(data.id);
            $.ajax({
                type: "GET",
                url: 'http://localhost:8080/nations',
                success: function (nations) {
                    let content = ''
                    for (let i=0; i<nations.length; i++) {
                        if (nations[i].id === data.nation.id) {
                            content += '<option value="'+nations[i].id+'" selected>'+nations[i].name+'</option>\n'
                        } else {
                            content += '<option value="'+nations[i].id+'">'+nations[i].name+'</option>\n'
                        }


                    }
                    document.getElementById("nationEdit").innerHTML = content;
                }
            })
        }
    })
    event.preventDefault();
}


function updateCity() {
    let name =  $('#cityNameEdit').val();
    let description =  $('#descriptionEdit').val();
    let gdp =  $('#gdpEdit').val();
    let population =  $('#populationEdit').val();
    let nation_id = $('#nationEdit').val();
    let area = $('#areaEdit').val();
    let cityId = $('#cityIdEdit').val();
    let data = {
        id: cityId,
        name : name,
        description: description,
        area : area,
        gdp: gdp,
        population:population,
        nation:{
            id : nation_id
        }
    }
    $.ajax({
        type: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        url: 'http://localhost:8080/cities/' + cityId,
        data: JSON.stringify(data),
        success: function (data) {
            getAllCities()
            $('#FormEditCity').modal('hide');
        }
    })
    event.preventDefault();
}

function deleteCity() {
    let cityId = $('#cityIdDelete').val()
    $.ajax({
        type: "DELETE",
        url: 'http://localhost:8080/cities/' + cityId,
        success: function (data) {
            closeDeleteForm()
            getAllCities()
        }
    });
    event.preventDefault();
}

function viewCity(id) {
    $('#FormDetails').modal('show');
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/cities/' +id,
        success: function (data) {
            let content =
                '            <div class="modal-header">\n' +
                '                <h5 class="modal-title" id="titleModal4">'+data.name+'</h5>\n' +
                '                 <button onclick="closeCityViewForm()" class="btn btn-primary">Xem Danh Sách Thành Phố</button>\n'+
                '            </div>\n' +
                '            <!-- body -->\n' +
                '            <div class="modal-body">\n' +
                '                <div class="modal-container">\n' +
                '                    <h3>Thành phố '+data.name+'</h3>\n' +
                '                        <div>\n' +
                '                            <h5>Tên: </h5>\n' +
                '                            <p>'+data.name+'</p>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3">\n' +
                '                            <h5>Quốc Gia: </h5>\n' +
                '                            <p>'+data.nation.name+'</p>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3">\n' +
                '                            <h5>Diện tích: </h5>\n' +
                '                            <p>'+data.area+'</p>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3">\n' +
                '                            <h5>Dân số: </h5>\n' +
                '                            <p>'+data.population+'</p>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3">\n' +
                '                            <h5>GDP: </h5>\n' +
                '                            <p>'+data.gdp+'</p>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3">\n' +
                '                            <h5>Giới thiệu: </h5>\n' +
                '                            <p>'+data.description+'</p>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3" id="btn_delete_yes" style="margin-left: 10px">\n' +
                '                            <button onclick="showUpdateCity('+data.id+')" class="btn btn-secondary">Cập Nhật</button>\n' +
                '                        </div>\n' +
                '                        <div class="mb-3" id="btn_home" style="margin-left: 10px">\n' +
                '                            <button onclick="showFormDeleteCity('+data.id+')" class="btn btn-secondary">Xóa</button>\n' +
                '                        </div>\n' +
                '                </div>\n' +
                '            </div>'

            document.getElementById('viewDetails').innerHTML = content
        }
    })
    event.preventDefault();



}

function closeCityAddForm(){
    $('#FormCity').modal('hide')
}

function resetForm(){
    $('#cityName').val("");
    $('#description').val("");
    $('#gdp').val("");
    $('#area').val("");
    $('#population').val("");
    $('#cityId').val("");
}

function closeCityEditForm(){
    $('#FormEditCity').modal('hide');
}

function closeDeleteForm() {
    $('#FormDelete').modal('hide')
}

function closeCityViewForm() {
    $('#FormDetails').modal('hide')
}

getAllCities()
getAllNations()