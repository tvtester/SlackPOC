package com.ts.loggers;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Attachment;
import com.slack.api.model.block.*;

import java.io.IOException;
import java.util.*;

public class SlackLogger {
    private static Slack slack;

    private static Slack getInstance(){
        try{
            if(slack == null){
                slack = Slack.getInstance();
            }
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
            return null;
        }
        return slack;
    }

    public static void postSlackMessageByText(String botToken, String channelID, String messageToPost){
        try{
            ChatPostMessageResponse response = getInstance().methods(botToken).chatPostMessage(req -> req
                    .channel(channelID)
                    .text(messageToPost));
            if (response.isOk()) {
                System.out.println("postedMessage: "+response.getMessage());
            } else {
                // e.g., "invalid_auth", "channel_not_found"
                System.out.println("errorCode: "+response.getError());
            }
        } catch (SlackApiException requestFailure) {
            // Slack API responded with unsuccessful status code (= not 20x)
            System.out.println("SlackApiException Exception: "+requestFailure.getMessage());
        } catch (IOException connectivityIssue) {
            // Throwing this exception indicates your app or Slack servers had a connectivity issue.
            System.out.println("IOException: "+connectivityIssue.getMessage());
        } catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }

    public static void postSlackMessageByBlock(String botToken, String channelID, List<LayoutBlock> blockList){
        try{
            ChatPostMessageResponse response = getInstance().methods(botToken).chatPostMessage(req -> req
                    .channel(channelID)
                    .blocks(blockList));
            if (response.isOk()) {
                System.out.println("postedMessage: "+response.getMessage());
            } else {
                // e.g., "invalid_auth", "channel_not_found"
                System.out.println("errorCode: "+response.getError());
            }
        } catch (SlackApiException requestFailure) {
            // Slack API responded with unsuccessful status code (= not 20x)
            System.out.println("SlackApiException Exception: "+requestFailure.getMessage());
        } catch (IOException connectivityIssue) {
            // Throwing this exception indicates your app or Slack servers had a connectivity issue.
            System.out.println("IOException: "+connectivityIssue.getMessage());
        } catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }

    public static void postSlackMessageByAttachment(String botToken, String channelID, List<Attachment> attachmentList){
        try{
            ChatPostMessageResponse response = getInstance().methods(botToken).chatPostMessage(req -> req
                    .channel(channelID)
                    .attachments(attachmentList));
            if (response.isOk()) {
                System.out.println("postedMessage: "+response.getMessage());
            } else {
                // e.g., "invalid_auth", "channel_not_found"
                System.out.println("errorCode: "+response.getError());
            }
        } catch (SlackApiException requestFailure) {
            // Slack API responded with unsuccessful status code (= not 20x)
            System.out.println("SlackApiException Exception: "+requestFailure.getMessage());
        } catch (IOException connectivityIssue) {
            // Throwing this exception indicates your app or Slack servers had a connectivity issue.
            System.out.println("IOException: "+connectivityIssue.getMessage());
        } catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
