$('#summernote').summernote({
    height: 300,                 // set editor height
    minHeight: null,             // set minimum height of editor
    maxHeight: null,             // set maximum height of editor
    focus: true,                  // set focus to editable area after initializing summernote
    callbacks : {
        onImageUpload : function(files, editor, welEditable){
            for (let i = files.length - 1 ; i >= 0; i--){
                uploadSummernoteImageFile(files[i], this);
            }
        }
    }
});

function uploadSummernoteImageFile(file,el){
    data = new FormData();
    data.append('file', file);
    $.ajax({
        data : data,
        type : 'POST',
        url : '/uploadImage',
        contentType : false,
        enctype : 'multipart/form-data',
        processData : false,
        success : function(data){
            $(el).summernote('editor.insertImage', data.url);
        }
    });
}