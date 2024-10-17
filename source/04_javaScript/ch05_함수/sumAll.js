function sumAll(){
    var result = 0;
    if(arguments.length == 0){
        return -999;
    }else if(arguments.length>=1){
        for(var i=0; i<arguments.length; i++){
            result += arguments[i];
        }
        return result;
    }
}