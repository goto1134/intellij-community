package com.intellij.localvcs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FileEntry extends Entry {
  // todo change String to ByteArray or something else
  private String myContent;

  public FileEntry(Integer objectId, String name, String content) {
    super(objectId, name);
    myContent = content;
  }

  public FileEntry(DataInputStream s) throws IOException {
    super(s);
    myContent = s.readUTF();
  }

  @Override
  public void write(DataOutputStream s) throws IOException {
    super.write(s);
    s.writeUTF(myContent);
  }

  @Override
  public String getContent() {
    return myContent;
  }

  @Override
  public Entry copy() {
    return new FileEntry(myObjectId, myName, myContent);
  }
}
