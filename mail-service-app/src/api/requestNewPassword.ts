import axios from 'axios';

export const apiRequestNewPassword = async (email: string): Promise<object> => {
    let user = {
        email
    }
    try {
        const response = await axios.post('http://localhost:8080/mail/newpassword', {
            "email": email
        })
        if (response.status === 200) {
            const body = await response.data
           
                try {
                    const response2 = await axios.post('http://localhost:8080/employee/register/customer', {
                            "email": body["email"]
                    });
                    if(response2.status === 200){
                        console.log("Request Sent Successfully!");
                    }
                    else if (response2.status === 500) {
                        return {
                            message: "Failed to send request!",
                            body: null
                        }
                    } else {
                        return {
                            message: "Something Went Wrong",
                            body: null
                        }
                    }
                } catch (e) {
                    console.log(e);
                    return {
                        registerMessage: "Something Went Wrong",
                    }
                }
            
           
            return {
                body,
                message: 'Your requet has been sent!'
            }
        } else if (response.status === 500) {
            return {
                message: "Failed to send request!",
                body: null
            }
        } else {
            return {
                message: "Something Went Wrong",
                body: null
            }
        }
    } catch (e) {
        console.log(user);
        console.log(e);
        return {
            registerMessage: "Something Went Wrong",

        }
    }
}