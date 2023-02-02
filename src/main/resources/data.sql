INSERT INTO public.navigation
    (text, icon)
VALUES
    ('home', 'fa-solid fa-house'),
    ('about', 'fa-solid fa-address-card'),
    ('experience', 'fa-solid fa-code'),
    ('project', 'fa-solid fa-diagram-project');

INSERT INTO public.home
    (intro, name, bio)
VALUES
    ('Hi, I am', 'Ryan Aristosa',  'Jr. Software Engineer at Cognizant Softvision');

INSERT INTO public.about
    (name, username)
VALUES
    ('Ryan Aristosa', '@ryan-aristosa');

INSERT INTO public.about_content
    (content)
VALUES
    ('I am Ryan Aristosa, but you can call me R. I am a Jr. Software Engineer at Cognizant Softvision, with some knowledge in building and connecting frontend to backend using services and API.'),
    ('I am a graduate of Bachelor of Science in Information Technology in STI College Pasay-EDSA as Magna Cum Laude. Me and my team are also awarded with Best Capstone Project Awardee.'),
    ('My hobbies are playing games, and watching anime and tv series. I am also a casual fan of K-pop, due to its songs and dance choreography. On some free time, I try to upskill myself through reading and trying different things.'),
    ('Lastly, I can say that I am perseverant, optimistic, responsible, and well-organized.');

INSERT INTO public.color
    (color_code)
VALUES
    ('c-eb'), ('c-dcb');

INSERT INTO public.stack
    (stack_name, color_id)
VALUES
    ('Java', '1'),
    ('C#', '1'),
    ('HTML', '1'),
    ('CSS', '1'),
    ('JavaScript', '2'),
    ('PHP', '1'),
    ('Bootstrap', '1'),
    ('Kotlin', '1'),
    ('Android Studio', '2'),
    ('Firebase', '2'),
    ('Python', '2'),
    ('Spring Boot', '1'),
    ('Hibernate', '1'),
    ('Git', '1'),
    ('Docker', '1'),
    ('PostgreSQL', '1'),
    ('React', '2');

INSERT INTO public.experience
    (duration)
VALUES
    ('2018 - August 2022 (College)'), ('October 2022 - Present');

INSERT INTO public.exp_description
    (text, experience_id)
VALUES
    ('Bachelor of Science in Information Technology', '1'),
    ('STI College Pasay-EDSA', '1'),
    ('Magna Cum Laude', '1'),
    ('Jr. Software Engineer', '2'),
    ('Cognizant Softvision', '2');

INSERT INTO public.exp_stack
    (experience_id, stack_id)
VALUES
    ('1', '1'), ('1', '5'), ('1', '3'), ('1', '4'), ('1', '2'), ('1', '8'), ('1', '7'), ('1', '6'), ('1', '11'),
    ('2', '1'), ('2', '12'), ('2', '13'), ('2', '14'), ('2', '15'), ('2', '16'), ('2', '17'), ('2', '7');

INSERT INTO public.project
    (title, description, contribution)
VALUES
    ('6Keeper', 'Password Security Application using 6KED (6Keeper Encryption/Decryption) System', 'Spearheaded the development; Helped in UI/UX; Solely developed the back-end'),
    ('skills-and-employees', 'Spring boot application for skills and employees with authorization and actuator', 'Led the development of the application'),
    ('billing', 'Final Exam in Bootcamp', 'Led the development of the application'),
    ('books-and-authors', 'Spring boot CRUD application for books and authors', 'Spearheaded the development of the application'),
    ('ryan-aristosa.github.io', 'Portfolio made in React', 'Solely developed the web page');
