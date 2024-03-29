USE [DouBan]
GO
/****** Object:  Table [dbo].[Performer_Award]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Performer_Award](
	[Award_Name] [nvarchar](30) NOT NULL,
	[Award_Message] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_Performer_Award] PRIMARY KEY CLUSTERED 
(
	[Award_Name] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Performer]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Performer](
	[Performer_ID] [nvarchar](15) NOT NULL,
	[Performer_Type] [nvarchar](4) NOT NULL,
	[Performer_Name] [nvarchar](20) NOT NULL,
	[Performer_Sex] [nchar](1) NOT NULL,
	[Performer_Birth] [date] NOT NULL,
 CONSTRAINT [PK_Performer] PRIMARY KEY CLUSTERED 
(
	[Performer_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Users_ID] [nvarchar](15) NOT NULL,
	[Account] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](16) NOT NULL,
	[Tel] [nvarchar](16) NOT NULL,
	[Users_Name] [nvarchar](10) NOT NULL,
	[Account_Type] [nvarchar](4) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Users_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Award]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Award](
	[Award_Name] [nvarchar](30) NOT NULL,
	[Award_Message] [nchar](200) NOT NULL,
 CONSTRAINT [PK_Movie_Award] PRIMARY KEY CLUSTERED 
(
	[Award_Name] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Movie_Title] [nvarchar](20) NOT NULL,
	[Writer] [nvarchar](20) NULL,
	[Country] [nvarchar](20) NOT NULL,
	[Movie_Date] [nvarchar](30) NOT NULL,
	[Movie_Time] [nvarchar](10) NOT NULL,
	[Language] [nvarchar](20) NOT NULL,
	[Another_Name] [nvarchar](50) NOT NULL,
	[Movie_Link] [nvarchar](50) NOT NULL,
	[Movie_Brief] [nvarchar](300) NOT NULL,
	[Total_Num] [int] NOT NULL,
	[Total_Score] [int] NOT NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[List]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[List](
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Label_Content] [nvarchar](10) NOT NULL,
	[LikeUsers_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [List_Prim] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC,
	[Label_Content] ASC,
	[LikeUsers_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Label]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Label](
	[Label_Content] [nvarchar](10) NOT NULL,
	[Users_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK__Label__1C2907AD5070F446] PRIMARY KEY CLUSTERED 
(
	[Label_Content] ASC,
	[Users_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Group_Discuss]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group_Discuss](
	[Discuss_ID] [nvarchar](15) NOT NULL,
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Users_ID] [nvarchar](15) NOT NULL,
	[Discuss_Title] [nvarchar](50) NOT NULL,
	[Discuss_Date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Discuss_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[Users_ID] [nvarchar](15) NOT NULL,
	[Movie_ID] [nvarchar](15) NOT NULL,
	[IsWatch] [nchar](1) NOT NULL,
	[Comment_Content] [nvarchar](500) NOT NULL,
	[Score] [int] NULL,
	[Comment_Date] [datetime] NOT NULL,
	[IsPhone] [nchar](1) NOT NULL,
 CONSTRAINT [Comment_Prim] PRIMARY KEY CLUSTERED 
(
	[Users_ID] ASC,
	[Movie_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Collect]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Collect](
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Users_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [Collect_Prim] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC,
	[Users_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Signs]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Signs](
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Label_Content] [nvarchar](10) NOT NULL,
 CONSTRAINT [Signs_Prim] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC,
	[Label_Content] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Performer_GetAward]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Performer_GetAward](
	[Award_Name] [nvarchar](30) NOT NULL,
	[Performer_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [Performer_GetAward_Prim] PRIMARY KEY CLUSTERED 
(
	[Award_Name] ASC,
	[Performer_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Watch]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Watch](
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Users_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [Watch_Prim] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC,
	[Users_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Participate]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Participate](
	[Performer_ID] [nvarchar](15) NOT NULL,
	[Movie_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [Participate_Prim] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC,
	[Performer_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_GetAward]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_GetAward](
	[Award_Name] [nvarchar](30) NOT NULL,
	[Movie_ID] [nvarchar](15) NOT NULL,
 CONSTRAINT [Movie_GetAward_Prim] PRIMARY KEY CLUSTERED 
(
	[Award_Name] ASC,
	[Movie_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Collect]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Collect](
	[Movie_ID] [nvarchar](15) NOT NULL,
	[Movie_Title] [nvarchar](30) NOT NULL,
 CONSTRAINT [Movie_Collect_Prim] PRIMARY KEY CLUSTERED 
(
	[Movie_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Participate_Discuss]    Script Date: 11/13/2019 21:01:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Participate_Discuss](
	[Discuss_ID] [nvarchar](15) NOT NULL,
	[Users_ID] [nvarchar](15) NOT NULL,
	[Discuss_Content] [nvarchar](500) NOT NULL,
 CONSTRAINT [Participate_Discuss_Prim] PRIMARY KEY CLUSTERED 
(
	[Discuss_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK__Collect__Movie_I__6E01572D]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Collect]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Collect__Users_I__6EF57B66]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Collect]  WITH CHECK ADD FOREIGN KEY([Users_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
/****** Object:  ForeignKey [FK__Comment__Movie_I__619B8048]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Comment__Users_I__60A75C0F]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([Users_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
/****** Object:  ForeignKey [FK__Group_Dis__Movie__778AC167]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Group_Discuss]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Group_Dis__Users__787EE5A0]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Group_Discuss]  WITH CHECK ADD FOREIGN KEY([Users_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
/****** Object:  ForeignKey [FK__Label__Users_ID__52593CB8]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Label]  WITH CHECK ADD FOREIGN KEY([Users_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
/****** Object:  ForeignKey [FK__List__LikeUsers___5DCAEF64]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[List]  WITH CHECK ADD FOREIGN KEY([LikeUsers_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
/****** Object:  ForeignKey [FK__List__Movie_ID__5BE2A6F2]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[List]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Movie_Col__Movie__71D1E811]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Movie_Collect]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Movie_Get__Award__48CFD27E]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Movie_GetAward]  WITH CHECK ADD FOREIGN KEY([Award_Name])
REFERENCES [dbo].[Movie_Award] ([Award_Name])
GO
/****** Object:  ForeignKey [FK__Movie_Get__Movie__49C3F6B7]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Movie_GetAward]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Participa__Movie__45F365D3]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Participate]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Participa__Perfo__44FF419A]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Participate]  WITH CHECK ADD FOREIGN KEY([Performer_ID])
REFERENCES [dbo].[Performer] ([Performer_ID])
GO
/****** Object:  ForeignKey [FK__Participa__Discu__7B5B524B]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Participate_Discuss]  WITH CHECK ADD FOREIGN KEY([Discuss_ID])
REFERENCES [dbo].[Group_Discuss] ([Discuss_ID])
GO
/****** Object:  ForeignKey [FK__Participa__Users__7C4F7684]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Participate_Discuss]  WITH CHECK ADD FOREIGN KEY([Users_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
/****** Object:  ForeignKey [FK__Performer__Award__4CA06362]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Performer_GetAward]  WITH CHECK ADD FOREIGN KEY([Award_Name])
REFERENCES [dbo].[Movie_Award] ([Award_Name])
GO
/****** Object:  ForeignKey [FK__Performer__Perfo__4D94879B]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Performer_GetAward]  WITH CHECK ADD FOREIGN KEY([Performer_ID])
REFERENCES [dbo].[Performer] ([Performer_ID])
GO
/****** Object:  ForeignKey [FK__Signs__Movie_ID__5535A963]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Signs]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Watch__Movie_ID__412EB0B6]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Watch]  WITH CHECK ADD FOREIGN KEY([Movie_ID])
REFERENCES [dbo].[Movie] ([Movie_ID])
GO
/****** Object:  ForeignKey [FK__Watch__Users_ID__4222D4EF]    Script Date: 11/13/2019 21:01:54 ******/
ALTER TABLE [dbo].[Watch]  WITH CHECK ADD FOREIGN KEY([Users_ID])
REFERENCES [dbo].[Users] ([Users_ID])
GO
