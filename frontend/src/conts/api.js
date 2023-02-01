import axios from "axios";

const HOST_URL = 'http://localhost:8082'
export function POST_API(file) {
    let formData = new FormData(); 
    formData.append("file", file)
    console.log(`업로드 파일 : ${file}`)
    axios({
        method: 'post',
<<<<<<< HEAD
        url: `${HOST_URL}/save`,
        params: {
            file
=======
        headers : {
            "Content-Type": "multipart/form-data",
        },
        url: `${HOST_URL}/api/save`,
        data: {
            formData
>>>>>>> 8b6c92e9e60e1c504330ae3b7a62564e2bb8c948
        }
      });
}


export async function GET_API() {
    try {
        fetch('./tmp.json')
        .then(res => console.log(res))
    } catch (error) {
        
    }

}