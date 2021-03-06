  const navSlide = () => {
            const burger = document.querySelector('.burger');
            const nav = document.querySelector('.nav-links');
            const navLinks = document.querySelectorAll('.nav-links li');

            //toggle view
            burger.addEventListener('click', () => {
                nav.classList.toggle('nav-active');
                //animate Links
                navLinks.forEach((link, index) =>{
                if(link.style.animation) {
                    link.style.animation = '';
                } else {
                    link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 1.5}s`;
                }
                });

            //burger animation
                burger.classList.toggle('toggle');
            });


        }

        const loginSuccessful = document.getElementById('loginSuccessful');
                const loginStatus = document.getElementById('loginStatus');

                function loggedInStatus() {
                    const body = document.getElementById('body');

                    if(loginSuccessful.innerText === 'true') {
                        loginStatus.innerText = 'Logout';
                    }
                    if(loginSuccessful.innerText === 'false') {
                        loginStatus.innerText = 'Login';
                    }
                }


        loggedInStatus();
        navSlide();