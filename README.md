Test 1
Verify users can add a Public Info text to the profile as a logged-in users
1. Navigate to the Login page as unauthenticated user
2. Verify the URL is correct
3. Enter valid credentials
4. Click the Sign-in button
5. Navigate to the Profile page
6. Open the "Edit Profile Pop Up"
7. Clear the "Public info" field if there is any content inside it
8. Type a text inside the "Public info" field
9. Submit the changes
10. Check the toast message text and verify it is correct
11. Confirm the text appeared on the profile page

Test 2
Verify users can submit posts
1. Navigate to the Login page as unauthenticated user
2. Verify the URL is correct
3. Enter valid credentials
4. Click the Sign-in button
5. Navigate to the Profile page
6. Check the post count
7. Navigate to the New Post page
8. Verify the URL is correct, and we are on the New post page
9. Upload an image
10. Add text to the post in the text input field
11. Click on the Submit button
12. Verify we are on the correct page by running a check that we are redirected to the Profile page after successfull submit
13. Get the new post count on the Profile page
14. Compare the new and the old post count on the profile page. We expect the new post count to be the old post count +1

Test 3
Verify that only logged in users can enter a profile page and follow other users
1. Navigate to the Homepage
2. Verify there are posts on the Homepage
3. Click on a username that is the author on one of these posts
4. Verify that the user is redirected to the 404 error page(page not found) meaning that unauthenticated users can't see a profile page
5. Navigate to the Login page as unauthenticated user
6. Verify the URL is correct
7. Enter valid credentials. Use an account that has no posts
8. Click the Sign-in button
9. Verify we are on the correct page after login
10. Get the text of a username
11. Get the text of the Follow button next to the username
12. Click on the Follow button 
13. Click on the username again
14. Verify the user profile page opens
15. Verify it is the same user by comparing the usernames (Posts page and Profile page)
16. Verify the Follow button has changed its value since it was clicked on the Posts page

Test 4 PostModalOperations
As a logged-in user I can like, dislike and post comments to posts
1. Navigate to the Login page as unauthenticated user
2. Verify the URL is correct
3. Enter valid credentials
4. Click the Sign-in button
5. Verify the user is on the posts page after login
6. Open one of the posts.
7. Like the post and verify it is liked
8. Remove the like and verify it is not liked
9. Dislike the post and verify it is disliked
10. Remove post dislike and verify it is no longer disliked
11. Like the post again and post a message
12. Refresh the page and verify the like and post are saved after page refresh

Test 5 SearchTest
Use Search to find and follow/unfollow users
2. Verify the URL is correct
3. Enter valid credentials
4. Click the Sign-in button
5. Verify the user is on the posts page after login
6. Start searching and verify the search dropdown with results appears
7. Check username and "Follow" button text on a specified row
8. Click on the Follow/Unfollow button on the same user to change the "Follow" status of the user
9. Click on the Followed/Unfollowed user
10. Verify a profile page opens
11. Once it loads check the text of the username and the follow button
12. Verify the username is the same and that the user "Follow" status has changed because it was clicked in the search results