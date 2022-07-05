const joinService = (function () {

    function checkDuplication(inputData, code, callback) {
        $.ajax({
            url: `/user/${code}`,
            type: "post",
            data: inputData,
            contentType: "application/json",
            async: false,
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    return {checkDuplication : checkDuplication}
})();
