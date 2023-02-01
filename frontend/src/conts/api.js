import axios from "axios";

const HOST_URL = 'http://localhost:8082'
export function POST_API(file) {
    let formData = new FormData(); 
    formData.append("file", file)
    console.log(`업로드 파일 : ${file}`)
    axios({
        method: 'post',
        headers : {
            "Content-Type": "multipart/form-data",
        },
        url: `${HOST_URL}/api/save`,
        data: {
            formData
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