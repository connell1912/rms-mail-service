import axios from 'axios';

export const apiChangePassword = async (password: string, username: string) => {
    // let user = {
    //     username,
    //     password
    // }
    try {
        const response2 = await axios.put('http://localhost:8080/employee/old', {
                username,
                password
                
        })
        .then (response =>{
            console.log(response.data);
        });
        
    } catch (e) {
        console.log(e);
    }

}

  
  
  