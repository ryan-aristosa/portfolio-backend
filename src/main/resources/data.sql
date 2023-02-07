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

INSERT INTO public.font_color
    (color_code)
VALUES
    ('c-eb'), ('c-dcb');

INSERT INTO public.stack
    (stack_name, primary_color_hex, font_color_id)
VALUES
    ('Java', '#EA2D2E', '1'),
    ('C#', '#68217A', '1'),
    ('HTML', '#E54D26', '1'),
    ('CSS', '#3D8FC6', '1'),
    ('JavaScript', '#F0DB4F', '2'),
    ('PHP', '#6181B6', '1'),
    ('Bootstrap', '#59407F', '1'),
    ('Kotlin', '#7F52FF', '1'),
    ('Android Studio', '#3DDC84', '2'),
    ('Firebase', '#FFCA28', '2'),
    ('Python', '#FFD845', '2'),
    ('Spring Boot', '#6DB33F', '1'),
    ('Hibernate', '#59666C', '1'),
    ('Git', '#F05032', '1'),
    ('Docker', '#2496ED', '1'),
    ('PostgreSQL', '#4169E1', '1'),
    ('React', '#61DAFB', '2'),
    ('SASS', '#CC6699', '1');

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
    (title, description, contribution, open_source_link)
VALUES
    (
        '6Keeper',
        'Password Security Application using 6KED (6Keeper Encryption/Decryption) System',
        'Spearheaded the development; Helped in UI/UX; Solely developed the back-end',
        'https://github.com/rynrsts/6Keeper'
    ),
    (
        'skills-and-employees',
        'Spring boot application for skills and employees with authorization and actuator',
        'Led the development of the application',
        'https://github.com/ryan-aristosa/skills-and-employees'
    ),
    (
        'billing',
        'Final Exam in Bootcamp',
        'Led the development of the application',
        'https://github.com/ryan-aristosa/billing'
    ),
    (
        'books-and-authors',
        'Spring boot CRUD application for books and authors',
        'Spearheaded the development of the application',
        'https://github.com/ryan-aristosa/books-and-authors'
    ),
    (
        'ryan-aristosa.github.io',
        'Portfolio made in React',
        'Solely developed the web page',
        'https://github.com/ryan-aristosa/ryan-aristosa.github.io'
    );

INSERT INTO public.project_stack
    (project_id, stack_id)
VALUES
    ('1', '8'), ('1', '9'), ('1', '10'),
    ('2', '1'), ('2', '12'), ('2', '13'),
    ('3', '1'), ('3', '12'), ('3', '13'),
    ('4', '1'), ('4', '12'), ('4', '13'),
    ('5', '17'), ('5', '7'), ('5', '18');

INSERT INTO public.contact
    (platform, icon)
VALUES
    ('Github', 'fa-brands fa-github'),
    ('LinkedIn', 'fa-brands fa-linkedin-in'),
    ('Email', 'fa-solid fa-envelope');

INSERT INTO public.account
    (account_name, link, contact_id)
VALUES
    ('ryan-aristosa', 'https://github.com/ryan-aristosa', '1'),
    ('rynrsts (Personal)', 'https://github.com/rynrsts', '1'),
    ('LinkedIn', 'https://www.linkedin.com/in/rynrsts/', '2'),
    ('Work email', 'mailto: ryan.aristosa@softvision.com', '3'),
    ('Personal email', 'mailto: ryanaristosa@outlook.com', '3');

INSERT INTO public.footer
    (text)
VALUES
    ('Copyright 2023 Ryan Aristosa. All rights reserved.');
